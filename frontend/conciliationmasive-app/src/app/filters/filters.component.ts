import {Component, OnInit, Output , EventEmitter} from '@angular/core';
// import { DatePipe } from '@angular/common';
import swal from 'sweetalert2';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { ConciliationmassiveService , DacTicketDTO } from '@tsir/conciliationmasive-api';
import { EstacionesService , TollDTO , CarrilesService , LaneDTO , TurnosService , ShiftDTO   } from '@tsir/tolls-api';



@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css']
})
export class FiltersComponent implements OnInit {

  @Output()
  listDacTickes = new EventEmitter<DacTicketDTO[]>();

  filterForm: FormGroup;

  tolls: TollDTO[];

  lanes: LaneDTO[];

  shifts: ShiftDTO[];

  date = new Date();

  disabled: boolean = true;

  constructor(private formBuilder: FormBuilder,
              private conciliationMasiveService: ConciliationmassiveService,
              private estacionesService: EstacionesService,
              private carrilesService: CarrilesService,
              private turnosService: TurnosService
  ) {
  }


  ngOnInit() {
    this.conciliationMasiveService.configuration.accessToken = localStorage.getItem('token');
    this.initLoginForm();
  }

  private initLoginForm() {
    this.filterForm = this.formBuilder.group({
      DATECOLLECTION: [this.date, Validators.required],
      STATIONAME: [null, Validators.required],
      LANECODE: [null],
      TURNCODE: [null],
    });
    this.estacionesService.findTolls(null).subscribe(
      result  => {
        this.tolls = result;
      }
    );
  }

  public loadParams() {
    let filtesr = this.filterForm.value;
    let map = {};

    console.log(' EN EL FORM : ' + this.filterForm.controls['TURNCODE'].value);
    if ( filtesr.DATECOLLECTION ) {
      map['DATECOLLECTION'] = filtesr.DATECOLLECTION;
      console.log( 'EN EL MAP[DATECOLLECTION ]: ' + map['DATECOLLECTION']);
    }
    console.log('Lane code '+filtesr.LANECODE);
    if ( filtesr.LANECODE != null ) {
      map['LANEID'] = filtesr.LANECODE;
      console.log( 'EN EL MAP[LANEID ]: ' + map['LANEID']);
    }
    if ( filtesr.TURNCODE ) {
      map['TURNCODE'] = filtesr.TURNCODE;
      console.log( 'EN EL MAP[TURNCODE ]: ' + map['TURNCODE']);
    }
    console.log('El mapeo queda de la siguiente manera ' + map);
    this.conciliationMasiveService.getDACTicket(map).subscribe(
      result => {
        this.listDacTickes.emit(result);
        console.log('Consumo realizado con exito ' + result);
      }, error => {
        console.log(error.error.code);
        if (error.error.code == '403') {
          swal.fire('No tiene permisos', `No posee permisos para esta accion`, 'error');
          console.log('No tiene autorizacion para esta accion' + error);
        }else{
          swal.fire('Hubo un error', `Hubo un error, por favor comuniquese con el administrador`, 'error');
          console.log('Hubo un error al invocar el microservicio ' + error);
        }
      }
    );

  }
  public LoadParametersStation(){
    if (this.filterForm.controls['STATIONAME'].value === null ){
      this.disabled = true;
    }else {
      this.disabled = false;
    }
    this.findLanes();
    this.findShifts();
  }

  public findLanes() {
    if ( this.filterForm.controls['STATIONAME'].value !== null ) {
      let map = {};
      map['TOLL'] = this.filterForm.controls['STATIONAME'].value;
      this.carrilesService.findLanes(map).subscribe(
        result => {
          this.lanes = result;
        }
      );
    }else {
      this.lanes = [];
    }
    this.filterForm.controls['LANECODE'].setValue(null);
  }

  public findShifts() {
   if (this.filterForm.controls['STATIONAME'].value !== null) {
      let map = {};
      map['TOLL'] = this.filterForm.controls['STATIONAME'].value;
      this.turnosService.findShifts(map).subscribe(
        result => {
          this.shifts = result;
          
        }
      );
    }else {
      this.shifts = [];
    }
    this.filterForm.controls['TURNCODE'].setValue(null);
  }
}

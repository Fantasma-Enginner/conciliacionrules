import {Component, OnInit} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {ConciliationmassiveService , DacTicketDTO, MassiveconciliationService, DetailTicketConcDTO, TicketStatus} from '@tsir/conciliationmasive-api';
import {ConciliacinService, ReconcileDTO} from '@tsir/conciliation-api';

import swal from 'sweetalert2';
import { isNull } from 'util';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'conciliationmasive-app';

  dacTicket: DacTicketDTO[] ;

  dacTicketaux: DacTicketDTO[] = [];

  filter: String = '';

  //filterConc: String = '';

  detailTicketConcDTO: DetailTicketConcDTO[] = [];

  conciliacionsFiltered: ReconcileDTO[];



  

  constructor(
    private conciliationmasiveService: ConciliationmassiveService,
    private massiveconciliationService: MassiveconciliationService,
    private conciliationService: ConciliacinService,
    private router: Router,
    ) {
    
    }

  ngOnInit() {
    this.conciliationmasiveService.getDACTicket().subscribe(
      result => {
        this.dacTicket = result;
      }, error => {

      }
    );




    
  }

  private getCategoriesFilter(){
    /*


    metodo en caso de que el filtro sea por URL


    let index: number = 0;
    this.filterConc += '?';
    this.dacTicketaux.forEach(element => {
      this.filterConc += 'CATEID='+element.category;
      if(this.dacTicketaux.length-1!=index){
        this.filterConc += '&';
      }
      index++;
    });
*/



    let map = {};
    this.dacTicketaux.forEach(element => {
      map['CATEID'] = element.category;
    });
    return map;
  }
  
  private getConciliationsFiltered(){
    this.conciliationService.getReconcile(this.getCategoriesFilter()).subscribe(parameter => {
        this.conciliacionsFiltered = parameter; 
    });
  }

  private getAllDetailTicketsConc(){
    this.conciliationmasiveService.getDetailTicket().subscribe(parameter => {
        this.detailTicketConcDTO = parameter; 
    });
  }



  public conciliationMasive() {
    


    //cuando este listo la api del tranDac


    this.getConciliationsFiltered();
    this.getAllDetailTicketsConc();


    for (let index = 0; index < this.detailTicketConcDTO.length; index++) {

      
      
      //temporal mientras se define, no va a ir laneId
      if(index < this.conciliacionsFiltered.length){
      this.detailTicketConcDTO[index].tranDacId = this.conciliacionsFiltered[index].laneId.toString();
      this.detailTicketConcDTO[index].ticketStatus = TicketStatus.NUMBER_3;
      this.massiveconciliationService.putReconcileMassive(this.detailTicketConcDTO[index]).subscribe(parameter => {
        
      });

    }
      
    }

    swal.fire('Conciliado', `Conciliado exitosamente!`, 'success');
    this.router.navigate(['/masive-app']);
    
  }

  public clear() {

  }


  public addItem(lst: DacTicketDTO[]) {
    this.dacTicket = lst;
  }

  public selectionConciliation(dacTicketDTO: DacTicketDTO, checked: boolean) {

    if(checked){
      //Agregamos al arreglo si no esta seleccionado el check
      this.dacTicketaux.push(dacTicketDTO);
    }else {
      //Remover al arreglo si ya se estaba seleccionado el check
      this.dacTicketaux.splice(this.dacTicketaux.indexOf(dacTicketDTO), 1);
    }
    console.log(this.dacTicketaux);

  }

}

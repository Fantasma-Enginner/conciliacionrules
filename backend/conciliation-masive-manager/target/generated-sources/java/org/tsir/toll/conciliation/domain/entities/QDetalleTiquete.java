package org.tsir.toll.conciliation.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDetalleTiquete is a Querydsl query type for DetalleTiquete
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDetalleTiquete extends EntityPathBase<DetalleTiquete> {

    private static final long serialVersionUID = -1907974416L;

    public static final QDetalleTiquete detalleTiquete = new QDetalleTiquete("detalleTiquete");

    public final NumberPath<Long> codigoestacion = createNumber("codigoestacion", Long.class);

    public final NumberPath<Long> codigoturno = createNumber("codigoturno", Long.class);

    public final NumberPath<Integer> estadotiquete = createNumber("estadotiquete", Integer.class);

    public final DatePath<java.time.LocalDate> fecharecaudo = createDate("fecharecaudo", java.time.LocalDate.class);

    public final NumberPath<Long> idcarril = createNumber("idcarril", Long.class);

    public final NumberPath<Long> idcate = createNumber("idcate", Long.class);

    public final NumberPath<Long> idconc = createNumber("idconc", Long.class);

    public final NumberPath<Long> iddetalletiquete = createNumber("iddetalletiquete", Long.class);

    public final NumberPath<Long> idinvetiqu = createNumber("idinvetiqu", Long.class);

    public final NumberPath<Long> idtrandac = createNumber("idtrandac", Long.class);

    public final NumberPath<Long> numerotiquete = createNumber("numerotiquete", Long.class);

    public QDetalleTiquete(String variable) {
        super(DetalleTiquete.class, forVariable(variable));
    }

    public QDetalleTiquete(Path<? extends DetalleTiquete> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDetalleTiquete(PathMetadata metadata) {
        super(DetalleTiquete.class, metadata);
    }

}


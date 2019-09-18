package com.alvaroramirez.entities;

import com.alvaroramirez.entities.Facturas;
import com.alvaroramirez.entities.Mesas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-18T08:41:18")
@StaticMetamodel(Meseros.class)
public class Meseros_ { 

    public static volatile SingularAttribute<Meseros, String> nombreMesero;
    public static volatile SingularAttribute<Meseros, Integer> idmesero;
    public static volatile ListAttribute<Meseros, Mesas> mesasList;
    public static volatile ListAttribute<Meseros, Facturas> facturasList;

}
package com.alvaroramirez.entities;

import com.alvaroramirez.entities.Areas;
import com.alvaroramirez.entities.Clientes;
import com.alvaroramirez.entities.Facturas;
import com.alvaroramirez.entities.Meseros;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-18T08:41:18")
@StaticMetamodel(Mesas.class)
public class Mesas_ { 

    public static volatile SingularAttribute<Mesas, Integer> idmesa;
    public static volatile SingularAttribute<Mesas, Areas> idarea;
    public static volatile ListAttribute<Mesas, Clientes> clientesList;
    public static volatile SingularAttribute<Mesas, Meseros> idmesero;
    public static volatile ListAttribute<Mesas, Facturas> facturasList;

}
package com.alvaroramirez.entities;

import com.alvaroramirez.entities.Clientes;
import com.alvaroramirez.entities.Detallefactura;
import com.alvaroramirez.entities.Mesas;
import com.alvaroramirez.entities.Meseros;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-18T08:41:18")
@StaticMetamodel(Facturas.class)
public class Facturas_ { 

    public static volatile SingularAttribute<Facturas, Mesas> idmesa;
    public static volatile ListAttribute<Facturas, Detallefactura> detallefacturaList;
    public static volatile SingularAttribute<Facturas, Clientes> idcliente;
    public static volatile SingularAttribute<Facturas, Meseros> idmesero;
    public static volatile SingularAttribute<Facturas, Integer> idfactura;

}
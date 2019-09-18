package com.alvaroramirez.entities;

import com.alvaroramirez.entities.Cocineros;
import com.alvaroramirez.entities.DetallefacturaPK;
import com.alvaroramirez.entities.Facturas;
import com.alvaroramirez.entities.Platos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-18T08:41:18")
@StaticMetamodel(Detallefactura.class)
public class Detallefactura_ { 

    public static volatile SingularAttribute<Detallefactura, DetallefacturaPK> detallefacturaPK;
    public static volatile SingularAttribute<Detallefactura, Facturas> facturas;
    public static volatile SingularAttribute<Detallefactura, Double> costoTotal;
    public static volatile SingularAttribute<Detallefactura, Integer> cantidad;
    public static volatile SingularAttribute<Detallefactura, Double> precioventa;
    public static volatile SingularAttribute<Detallefactura, Cocineros> idcocinero;
    public static volatile SingularAttribute<Detallefactura, Platos> platos;

}
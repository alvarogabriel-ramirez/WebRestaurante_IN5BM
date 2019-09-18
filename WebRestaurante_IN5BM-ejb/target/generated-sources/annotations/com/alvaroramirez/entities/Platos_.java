package com.alvaroramirez.entities;

import com.alvaroramirez.entities.Detallefactura;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-18T08:41:18")
@StaticMetamodel(Platos.class)
public class Platos_ { 

    public static volatile SingularAttribute<Platos, String> descripcion;
    public static volatile SingularAttribute<Platos, Double> costo;
    public static volatile ListAttribute<Platos, Detallefactura> detallefacturaList;
    public static volatile SingularAttribute<Platos, Integer> idplato;

}
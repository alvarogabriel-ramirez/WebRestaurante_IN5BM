package com.alvaroramirez.entities;

import com.alvaroramirez.entities.Mesas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2019-09-18T08:41:18")
@StaticMetamodel(Areas.class)
public class Areas_ { 

    public static volatile SingularAttribute<Areas, String> nombreArea;
    public static volatile SingularAttribute<Areas, Integer> idarea;
    public static volatile SingularAttribute<Areas, Integer> numEmpleados;
    public static volatile ListAttribute<Areas, Mesas> mesasList;

}
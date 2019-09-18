package com.alvaroramirez.manegedbeans;

import com.alvaroramirez.entities.Detallefactura;
import com.alvaroramirez.manegedbeans.util.JsfUtil;
import com.alvaroramirez.manegedbeans.util.JsfUtil.PersistAction;
import com.alvaroramirez.sessionsbeans.DetallefacturaFacadeLocal;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("detallefacturaController")
@SessionScoped
public class DetallefacturaController implements Serializable {

    @EJB
    private DetallefacturaFacadeLocal ejbFacade;
    private List<Detallefactura> items = null;
    private Detallefactura selected;

    public DetallefacturaController() {
    }

    public Detallefactura getSelected() {
        return selected;
    }

    public void setSelected(Detallefactura selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getDetallefacturaPK().setIdplato(selected.getPlatos().getIdplato());
        selected.getDetallefacturaPK().setIdfactura(selected.getFacturas().getIdfactura());
    }

    protected void initializeEmbeddableKey() {
        selected.setDetallefacturaPK(new com.alvaroramirez.entities.DetallefacturaPK());
    }

    private DetallefacturaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Detallefactura prepareCreate() {
        selected = new Detallefactura();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DetallefacturaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DetallefacturaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DetallefacturaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Detallefactura> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Detallefactura getDetallefactura(com.alvaroramirez.entities.DetallefacturaPK id) {
        return getFacade().find(id);
    }

    public List<Detallefactura> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Detallefactura> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Detallefactura.class)
    public static class DetallefacturaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DetallefacturaController controller = (DetallefacturaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "detallefacturaController");
            return controller.getDetallefactura(getKey(value));
        }

        com.alvaroramirez.entities.DetallefacturaPK getKey(String value) {
            com.alvaroramirez.entities.DetallefacturaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.alvaroramirez.entities.DetallefacturaPK();
            key.setIdplato(Integer.parseInt(values[0]));
            key.setIdfactura(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.alvaroramirez.entities.DetallefacturaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdplato());
            sb.append(SEPARATOR);
            sb.append(value.getIdfactura());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Detallefactura) {
                Detallefactura o = (Detallefactura) object;
                return getStringKey(o.getDetallefacturaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Detallefactura.class.getName()});
                return null;
            }
        }

    }

}

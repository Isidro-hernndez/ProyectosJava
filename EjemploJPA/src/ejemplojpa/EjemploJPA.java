/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author thank
 */
public class EjemploJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code applicationogic here
        try{
            EntityManagerFactory enf = Persistence.createEntityManagerFactory("EjemploJPAPU");
            EntityManager em = enf.createEntityManager();            
            
            //Empleado empleado = new Empleado();
            Contacts contacto = new Contacts();
            //empleado.setNoempleado(450);
            contacto.setIDContact(450);
            //empleado.setNombre("Mickey Mouse");
            //Contacts contacto = em.createNamedQuery("Contacts.findByIDContact").setParameter("iDContact", 14).getSingleResult();
            contacto.setName("El raton Miguelito");
            
            List<Empleado> empleados = em.createNamedQuery("empleados.findAll").getResultList();
            
            for (Empleado empleado : empleados){
                System.out.println("\t* "+empleado.getId()+" "+empleado.getNoEmpleado()+" "+" - "+cobro.getMonto());
            }
           /* EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(contacto);
            tx.commit();*/
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
}

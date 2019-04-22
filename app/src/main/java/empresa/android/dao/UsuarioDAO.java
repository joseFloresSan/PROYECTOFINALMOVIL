package empresa.android.dao;

  import android.content.Intent;

  import  empresa.android.bean.UsuarioBean;
  import empresa.android.principal.FrmLoginEstudiante;

public class UsuarioDAO
{
    // datos de acceso de  estudiantes
       String usuarioestu[]={"ivan","ciro","larissa","alberto"};
       String passwordestu[]={"123","1234","12345","123456"};

    // datos de  acceso del  persona
      // administrador
      String usuarioadmin[]={"admin1","admin2","admin3","admin4"};
      String passwordadmin[]={"123","1234","12345","123456"};
    // docente
      String usuariodocente[]={"docente1","docente2","docente3","docente4"};
      String passworddocente[]={"123","1234","12345","123456"};

    public boolean    ValidarUsuario(UsuarioBean   objUsuarioBean)
    {
        boolean   estado=false;
        int  op=Integer.parseInt(objUsuarioBean.getTipousuario());
        try
        {
          switch(op)
          {   case 1:
              {
                  for(int i=0;i<usuarioadmin.length;i++)
                  {
                      if(objUsuarioBean.getUsuario().equals(usuarioadmin[i]) &&
                          objUsuarioBean.getPassword().equals(passwordadmin[i]))
                      {
                         estado=true;
                         break;
                      }
              }
               break;
              }
              case 2:
              {
                  for(int i=0;i<usuariodocente.length;i++)
                  {
                      if(objUsuarioBean.getUsuario().equals(usuariodocente[i]) &&
                              objUsuarioBean.getPassword().equals(passworddocente[i]))
                      {
                          estado=true;
                          break;
                      }
                  }
                  break;
              }
              case 3:
              {
                  for(int i=0;i<usuariodocente.length;i++)
                  {
                      if(objUsuarioBean.getUsuario().equals(usuarioestu[i]) &&
                              objUsuarioBean.getPassword().equals(passwordestu[i]))
                      {
                          estado=true;
                          break;
                      }
                  }
                  break;
              }
          }
        }
        catch (Exception  e)
        {
            estado=false;
        }
        return estado;


    }


}

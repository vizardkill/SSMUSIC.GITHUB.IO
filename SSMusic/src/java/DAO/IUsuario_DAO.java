/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Log;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author scardonas
 */
public interface IUsuario_DAO {
    
    public Boolean setUser(Usuario user);

    public List<Usuario> getUser();

    public boolean updateUser(Usuario user);

    public boolean deleteUser(Usuario user);
    public Usuario getOneUser(Usuario user);
}

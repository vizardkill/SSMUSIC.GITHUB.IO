/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Usuario;
import DAO.IUsuario_DAO;
import Metodos.SegurityPass;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author scardonas
 */
public class controller_user {

    public controller_user() {
    }

    public boolean registerUser(Usuario user) {
        SegurityPass md5 = new SegurityPass();

        String hash = md5.getMD5(user.getPass());
        user.setPass(hash);

        IUsuario_DAO udao = new DAO_Usuario();
        boolean result = udao.setUser(user);
        return result;
    }

    public void updateUser(Usuario user) {
        IUsuario_DAO udao = new DAO_Usuario();
        udao.updateUser(user);
    }

    public boolean deleteUser(Usuario user) {
        IUsuario_DAO udao = new DAO_Usuario();
        boolean result = udao.deleteUser(user);
        return result;
    }

    public Usuario getOneUser(Usuario user) {
        SegurityPass md5 = new SegurityPass();
        String hash = md5.getMD5(user.getPass());
        user.setPass(hash);

        Usuario users;
        IUsuario_DAO udao = new DAO_Usuario();
        users = udao.getOneUser(user);

        return users;
    }

    public List<Usuario> getUsers() {
        IUsuario_DAO udao = new DAO_Usuario();
        List<Usuario> users = udao.getUser();
        return users;
    }
}

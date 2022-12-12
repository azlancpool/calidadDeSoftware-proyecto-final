package com.compunet.acceso;

import com.compunet.modelo.CBDD;
import java.sql.ResultSet;

public class Usuarios {

	private int idUsuario;
	private String usuarioUsuario;
	private String claveUsuario;
	private String rolUsuario;
	private String buscarUsuario;
	private CBDD c;

	public Usuarios() {
		c = new CBDD();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuarioUsuario() {
		return usuarioUsuario;
	}

	public void setUsuarioUsuario(String usuarioUsuario) {
		this.usuarioUsuario = usuarioUsuario;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public String getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public String getBuscarUsuario() {
		return buscarUsuario;
	}

	public void setBuscarUsuario(String buscarUsuario) {
		this.buscarUsuario = buscarUsuario;
	}

	public ResultSet verificarUsuario(String usuario, String clave) {
		setUsuarioUsuario(usuario);
		setClaveUsuario(clave);
		String sql = "SELECT * FROM `usuario`\n" + "WHERE `usuario_u` = '" + getUsuarioUsuario() + "'\n"
				+ "and `clave_u` = SHA1('" + getClaveUsuario() + "')";
		return c.consulta(sql);
	}
}

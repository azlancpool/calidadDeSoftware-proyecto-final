package com.compunet.acceso;

import com.compunet.modelo.CBDD;
import java.sql.ResultSet;

public class Productos {

    private int idProductos;
    private int idProveedoresProductos;
    private String nombreProductos;
    private String descripcionProductos;
    private double valorRefCompProductos;
    private double valorRefVentaProductos;
    private int stockProductos;
    private String tieneIvaProductos;
    private String tipoProductos;
    private String buscar;
    private CBDD c;

    public Productos() {
        c = new CBDD();
    }

    

    public int getIdProductos() {
		return idProductos;
	}



	public void setIdProductos(int idProductos) {
		this.idProductos = idProductos;
	}



	public int getIdProveedoresProductos() {
		return idProveedoresProductos;
	}



	public void setIdProveedoresProductos(int idProveedoresProductos) {
		this.idProveedoresProductos = idProveedoresProductos;
	}



	public String getNombreProductos() {
		return nombreProductos;
	}



	public void setNombreProductos(String nombreProductos) {
		this.nombreProductos = nombreProductos;
	}



	public String getDescripcionProductos() {
		return descripcionProductos;
	}



	public void setDescripcionProductos(String descripcionProductos) {
		this.descripcionProductos = descripcionProductos;
	}



	public double getValorRefCompProductos() {
		return valorRefCompProductos;
	}



	public void setValorRefCompProductos(double valorRefCompProductos) {
		this.valorRefCompProductos = valorRefCompProductos;
	}



	public double getValorRefVentaProductos() {
		return valorRefVentaProductos;
	}



	public void setValorRefVentaProductos(double valorRefVentaProductos) {
		this.valorRefVentaProductos = valorRefVentaProductos;
	}



	public int getStockProductos() {
		return stockProductos;
	}



	public void setStockProductos(int stockProductos) {
		this.stockProductos = stockProductos;
	}



	public String getTieneIvaProductos() {
		return tieneIvaProductos;
	}



	public void setTieneIvaProductos(String tieneIvaProductos) {
		this.tieneIvaProductos = tieneIvaProductos;
	}



	public String getTipoProductos() {
		return tipoProductos;
	}



	public void setTipoProductos(String tipoProductos) {
		this.tipoProductos = tipoProductos;
	}



	public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public CBDD getC() {
        return c;
    }

    public void setC(CBDD c) {
        this.c = c;
    }

    public boolean insertProductos(int ip, String n, String d, double vc, double vv, int s, String ti, String tp) { // nnombre, ruc, contacto, dir3eccion

        setIdProveedoresProductos(ip);
        setNombreProductos(n);
        setDescripcionProductos(d);
        setValorRefCompProductos(vc);
        setValorRefVentaProductos(vv);
        setStockProductos(s);
        setTieneIvaProductos(ti);
        setTipoProductos(tp);
        String sql = "INSERT INTO `productos`"
                + "(`IdProveedores_prod`, `nombre_prod`, `descripcion_prod`, `valorRefComp_prod`, "
                + "`valorRefVenta_prod`, `stock_prod`, `tieneIva_prod`, tipo_prod) "
                + "VALUES "
                + "('" + getIdProveedoresProductos() + "',"
                + "'" + getNombreProductos() + "',"
                + "'" + getDescripcionProductos() + "',"
                + "'" + getValorRefCompProductos() + "',"
                + "'" + getValorRefVentaProductos() + "',"
                + "'" + getStockProductos() + "',"
                + "'" + getTieneIvaProductos() + "',"
                + "'" + getTipoProductos() + "')";

        return this.c.ejecutar(sql);
    }

    public boolean deleteProductos(int id) {
        setIdProductos(id);
        String sql = "DELETE FROM `productos`\n"
                + "WHERE `id_prod` =" + getIdProductos();
        return c.ejecutar(sql);
    }

    public boolean updateProductos(int id, int ip, String n, String d, double vc, double vv, int s, String ti, String tp) {
        setIdProductos(id);
        setIdProveedoresProductos(ip);
        setNombreProductos(n);
        setDescripcionProductos(d);
        setValorRefCompProductos(vc);
        setValorRefVentaProductos(vv);
        setStockProductos(s);
        setTieneIvaProductos(ti);
        setTipoProductos(tp);
        String sql = "UPDATE `productos` SET `idProveedores_prod`='" + getIdProveedoresProductos() + "',\n"
                + "`idProveedores_prod`='" + getIdProveedoresProductos() + "',\n"
                + "`descripcion_prod`='" + getDescripcionProductos() + "',\n"
                + "`valorRefComp_prod`=" + getValorRefCompProductos() + ",\n"
                + "`valorRefVenta_prod`=" + getValorRefVentaProductos() + ",\n"
                + "`stock_prod`=" + getStockProductos() + ",\n"
                + "`tieneIva_prod`='" + getTieneIvaProductos() + "',\n"
                + "`tipo_prod`='" + getTipoProductos() + "'\n"
                + "WHERE `id_prod`=" + getIdProductos();
        return this.c.ejecutar(sql);
    }

    public ResultSet selectProductos(String b) {
        setBuscar(b);
        String sql = "SELECT * FROM `productos`\n"
                + "WHERE `nombre_prod` like '%" + getBuscar() + "%'\n"
                + "or `descripcion_prod` like '%" + getBuscar() + "%'";
        return c.consulta(sql);
    }

}

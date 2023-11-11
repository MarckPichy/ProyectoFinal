package com.app.PROYECTOFINAL02.entidad;


import jakarta.persistence.*;

@Entity
@Table(name = "laboratorios")
public class Laboratorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigolaboratorio", nullable = false, length = 50)
    private String codigolaboratorio;

    @Column(name = "serviciolaboratorio", nullable = false, length = 50)
    private String serviciolaboratorio;

    @Column(name = "proveedor", nullable = false, length = 50, unique = true)
    private String proveedor;

    @Column(name = "cantidad", nullable = false, length = 50, unique = true)
    private int cantidad;

    @Column(name = "precio", nullable = false, length = 50, unique = true)
    private float precio;

    public Laboratorio(){

    }

    public Laboratorio(Long id, String codigolaboratorio, String serviciolabortorio, String proveedor, int cantidad, float precio) {
        super();
        this.id = id;
        this.codigolaboratorio = codigolaboratorio;
        this.serviciolaboratorio = serviciolabortorio;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Laboratorio(String codigolaboratorio, String serviciolabortorio, String proveedor, int cantidad, float precio) {
        this.codigolaboratorio = codigolaboratorio;
        this.serviciolaboratorio = serviciolabortorio;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigolaboratorio() {
        return codigolaboratorio;
    }

    public void setCodigolaboratorio(String codigolaboratorio) {
        this.codigolaboratorio = codigolaboratorio;
    }

    public String getServiciolabortorio() {
        return serviciolaboratorio;
    }

    public void setServiciolabortorio(String serviciolabortorio) {
        this.serviciolaboratorio = serviciolabortorio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Laboratorio{" +
                "id=" + id +
                ", codigolaboratorio='" + codigolaboratorio + '\'' +
                ", serviciolabortorio='" + serviciolaboratorio + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }

}

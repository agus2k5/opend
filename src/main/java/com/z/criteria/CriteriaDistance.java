/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.criteria;

import com.z.models.Establecimiento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mariano
 */
public class CriteriaDistance implements Criteria {

    private double distanceKM;
    private float my_lat;
    private float my_lon;

    public CriteriaDistance(float my_lat, float my_lon, double distanceKM) {
        this.distanceKM = distanceKM;
        this.my_lat = my_lat;
        this.my_lon = my_lon;
    }
    private double getDistance2(Establecimiento establecimiento){
        double latitud_radianes = Math.toRadians(my_lat);
        double to_latitud_radianes = Math.toRadians(establecimiento.getLatitud());
        double delta_longitud = Math.toRadians(my_lon - establecimiento.getLongitud());
        return (Math.acos(
                Math.sin(latitud_radianes)
                * Math.sin(to_latitud_radianes)
                + Math.cos(latitud_radianes)
                * Math.cos(to_latitud_radianes)
                * Math.cos(delta_longitud)
        ) * 180 / Math.PI)*100;
    }
    private double getDistanceTo(Establecimiento establecimiento) {
        double latitud_radianes = my_lat * Math.PI / 180;
        double to_latitud_radianes = establecimiento.getLatitud() * Math.PI / 180;
        double delta_longitud = (my_lon - establecimiento.getLongitud()) * Math.PI / 180;
        return (Math.acos(
                Math.sin(latitud_radianes)
                * Math.sin(to_latitud_radianes)
                + Math.cos(latitud_radianes)
                * Math.cos(to_latitud_radianes)
                * Math.cos(delta_longitud)
        ) * 180 / Math.PI) * 60 * 1.1515;
    }

    @Override
    public List<Establecimiento> meetCriteria(List<Establecimiento> establecimientos) {
        List<Establecimiento> inRange = new ArrayList<Establecimiento>();
        for (Establecimiento establecimiento : establecimientos) {
            double dist = getDistance2(establecimiento);
            System.out.println(establecimiento.getNombre() + "\tDist: " + dist);
            if (dist <= this.distanceKM) {
                inRange.add(establecimiento);
            }
        }
        return inRange;
    }

}

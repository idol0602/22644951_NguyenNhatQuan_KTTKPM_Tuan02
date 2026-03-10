package edu.iuh.fit;

import edu.iuh.fit.Bai1.Logistics;
import edu.iuh.fit.Bai1.RoadLogistics;
import edu.iuh.fit.Bai1.SeaLogistics;
import edu.iuh.fit.Bai2.FurnitureFactory;
import edu.iuh.fit.Bai2.InteriorDesigner;
import edu.iuh.fit.Bai2.ModernFurnitureFactory;
import edu.iuh.fit.Bai2.VictorianFurnitureFactory;

public class Main {
    public static void main(String[] args) {

        // Bài 1

//        Logistics logistics;
//
//        // chọn loại vận chuyển
//        String type = "road";
//
//        if (type.equals("road")) {
//            logistics = new RoadLogistics();
//        } else {
//            logistics = new SeaLogistics();
//        }
//
//        logistics.planDelivery();

        //Bài 2

        FurnitureFactory factory;

        String style = "modern";

        if (style.equals("modern")) {
            factory = new ModernFurnitureFactory();
        } else {
            factory = new VictorianFurnitureFactory();
        }

        InteriorDesigner room = new InteriorDesigner(factory);
        room.decorate();
    }
}
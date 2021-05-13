package entities;


import java.util.ArrayList;
import java.util.List;

public class utilities {
public static List<Voiture> getEquipes(){
	List<Voiture>v=new ArrayList<>();
	
	v.add(new Voiture("bmw","bmw","https://www.bmw-tunisia.com/content/dam/bmw/common/all-models/2-series/gran-coupe/2019/Inspire-Highligt/bmw-2-series-gran-coupe-inspire-ag-sp-xxl.jpg",4));
	v.add(new Voiture("mercedes","mercedes","https://e7.pngegg.com/pngimages/625/638/png-clipart-mercedes-mercedes.png",4));
	v.add(new Voiture("mahindra","mahindra","https://img2.freepng.fr/20180428/hbw/kisspng-mahindra-mahindra-car-india-mahindra-scorpio-5ae4b469155d55.4818999915249378330875.jpg",4));
	return v;
}
}

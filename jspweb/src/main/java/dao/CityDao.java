package dao;

import java.util.ArrayList;

import dto.City;

public class CityDao extends Dao {
 
	public CityDao() {
		super();
	}
	
	public static CityDao cityDao = new CityDao();
	public static CityDao getCityDao() {
		return cityDao;
	}
	
	public ArrayList<City> getCitylist(){
		ArrayList<City> citylist = new ArrayList<City>();
		
		String sql = "select * from city";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				City city = new City (
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3)
						);
				citylist.add(city);
			}
			return citylist;
		} catch (Exception e) {
			System.out.println("오류 " + e);
		}
		return null;
	}
}

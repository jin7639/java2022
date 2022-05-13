package dao;

import java.util.ArrayList;

import dto.City;
import dto.Player;

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
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getString(7)
						);
				citylist.add(city);
			}
			return citylist;
		} catch (Exception e) {
			System.out.println("오류 " + e);
		}
		return null;
	}
	
	public City getCity(int cindex) {
		String sql = "select cname from city where cindex="+cindex;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
		} catch (Exception e) {
			System.out.println("오류 " + e);
		}		
		
		return null;
	}
	
	public boolean player(String cplayer) {
		String sql = "insert into player (cplayer) value(?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cplayer);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("오류 " + e);
		}
		return false;
	}
	
	
	
}

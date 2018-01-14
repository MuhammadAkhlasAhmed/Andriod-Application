package com.app.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.app.dao.ItemReviewDao;
import com.app.model.ItemReview;

@Repository
public class ItemReviewDaoImpl extends JdbcDaoSupport implements ItemReviewDao{

	public static List<ItemReview> resultSet;
	
	@Autowired 
    private	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public List<ItemReview> getAllItemReviews() {
		String sql = "SELECT * FROM item_review";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<ItemReview> result = new ArrayList<ItemReview>();
		for(Map<String, Object> row : rows){
			ItemReview itemReview = new ItemReview();
			itemReview.setId(Long.parseLong((row.get("item_id").toString())));
			itemReview.setAction(row.get("action").toString());
			itemReview.setAdventure(row.get("adventure").toString());
			itemReview.setAnimation(row.get("animation").toString());
			itemReview.setChildrens(row.get("childrens").toString());
			itemReview.setComedy(row.get("comedy").toString());
			itemReview.setCrime(row.get("crime").toString());
			itemReview.setDocumentary(row.get("documentary").toString());
			itemReview.setDrama(row.get("drama").toString());
			itemReview.setFantasy(row.get("fantasy").toString());
			itemReview.setFilmNoir(row.get("film_noir").toString());
			itemReview.setHorror(row.get("horror").toString());
			itemReview.setMusical(row.get("musical").toString());
			itemReview.setMystery(row.get("mystery").toString());
			itemReview.setRomance(row.get("romance").toString());
			itemReview.setSciFi(row.get("sci_fi").toString());
			itemReview.setThriller(row.get("thriller").toString());
			itemReview.setWar(row.get("war").toString());
			itemReview.setWestern(row.get("western").toString());
			itemReview.setFamily(row.get("family").toString());
			result.add(itemReview);
		}
		
		return result;
	}

	@Override
	public List<ItemReview> getRowAgainsGenres(List<String> list) {
		
		if(list.size() == 1) {
			String sql = "SELECT * FROM item_review where ("+list.get(0).toLowerCase()+"='1' and "+list.get(1).toLowerCase()+"='1') or ("+list.get(2).toLowerCase()+") ";	
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			resultSet = new ArrayList<ItemReview>();
			for(Map<String, Object> row : rows){
				ItemReview itemReview = new ItemReview();
				itemReview.setId(Long.parseLong((row.get("item_id").toString())));
				itemReview.setAction(row.get("action").toString());
				itemReview.setAdventure(row.get("adventure").toString());
				itemReview.setAnimation(row.get("animation").toString());
				itemReview.setChildrens(row.get("childrens").toString());
				itemReview.setComedy(row.get("comedy").toString());
				itemReview.setCrime(row.get("crime").toString());
				itemReview.setDocumentary(row.get("documentary").toString());
				itemReview.setDrama(row.get("drama").toString());
				itemReview.setFantasy(row.get("fantasy").toString());
				itemReview.setFilmNoir(row.get("film_noir").toString());
				itemReview.setHorror(row.get("horror").toString());
				itemReview.setMusical(row.get("musical").toString());
				itemReview.setMystery(row.get("mystery").toString());
				itemReview.setRomance(row.get("romance").toString());
				itemReview.setSciFi(row.get("sci_fi").toString());
				itemReview.setThriller(row.get("thriller").toString());
				itemReview.setWar(row.get("war").toString());
				itemReview.setWestern(row.get("western").toString());
				itemReview.setFamily(row.get("family").toString());
				resultSet.add(itemReview);
			}
		} if(list.size() == 2) {
	String sql = "SELECT * FROM item_review where "+list.get(0).toLowerCase()+"='1' and "+list.get(1).toLowerCase()+"='1'";	
	List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
	resultSet = new ArrayList<ItemReview>();
	for(Map<String, Object> row : rows){
		ItemReview itemReview = new ItemReview();
		itemReview.setId(Long.parseLong((row.get("item_id").toString())));
		itemReview.setAction(row.get("action").toString());
		itemReview.setAdventure(row.get("adventure").toString());
		itemReview.setAnimation(row.get("animation").toString());
		itemReview.setChildrens(row.get("childrens").toString());
		itemReview.setComedy(row.get("comedy").toString());
		itemReview.setCrime(row.get("crime").toString());
		itemReview.setDocumentary(row.get("documentary").toString());
		itemReview.setDrama(row.get("drama").toString());
		itemReview.setFantasy(row.get("fantasy").toString());
		itemReview.setFilmNoir(row.get("film_noir").toString());
		itemReview.setHorror(row.get("horror").toString());
		itemReview.setMusical(row.get("musical").toString());
		itemReview.setMystery(row.get("mystery").toString());
		itemReview.setRomance(row.get("romance").toString());
		itemReview.setSciFi(row.get("sci_fi").toString());
		itemReview.setThriller(row.get("thriller").toString());
		itemReview.setWar(row.get("war").toString());
		itemReview.setWestern(row.get("western").toString());
		itemReview.setFamily(row.get("family").toString());
		resultSet.add(itemReview);
	}
		} if(list.size() == 3) {
			String sql = "SELECT * FROM item_review where ("+list.get(0).toLowerCase()+"='1' and "+list.get(1).toLowerCase()+"='1') or ("+list.get(2).toLowerCase()+"='1') ";	
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			resultSet = new ArrayList<ItemReview>();
			for(Map<String, Object> row : rows){
				ItemReview itemReview = new ItemReview();
				itemReview.setId(Long.parseLong((row.get("item_id").toString())));
				itemReview.setAction(row.get("action").toString());
				itemReview.setAdventure(row.get("adventure").toString());
				itemReview.setAnimation(row.get("animation").toString());
				itemReview.setChildrens(row.get("childrens").toString());
				itemReview.setComedy(row.get("comedy").toString());
				itemReview.setCrime(row.get("crime").toString());
				itemReview.setDocumentary(row.get("documentary").toString());
				itemReview.setDrama(row.get("drama").toString());
				itemReview.setFantasy(row.get("fantasy").toString());
				itemReview.setFilmNoir(row.get("film_noir").toString());
				itemReview.setHorror(row.get("horror").toString());
				itemReview.setMusical(row.get("musical").toString());
				itemReview.setMystery(row.get("mystery").toString());
				itemReview.setRomance(row.get("romance").toString());
				itemReview.setSciFi(row.get("sci_fi").toString());
				itemReview.setThriller(row.get("thriller").toString());
				itemReview.setWar(row.get("war").toString());
				itemReview.setWestern(row.get("western").toString());
				itemReview.setFamily(row.get("family").toString());
				resultSet.add(itemReview);
			}
		} if(list.size() == 4) {
			String sql = "SELECT * FROM item_review where ("+list.get(0).toLowerCase()+"='1' and "+list.get(1).toLowerCase()+"='1') or ("+list.get(2).toLowerCase()+"='1' and "+list.get(3).toLowerCase()+"='1')";	
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			resultSet = new ArrayList<ItemReview>();
			for(Map<String, Object> row : rows){
				ItemReview itemReview = new ItemReview();
				itemReview.setId(Long.parseLong((row.get("item_id").toString())));
				itemReview.setAction(row.get("action").toString());
				itemReview.setAdventure(row.get("adventure").toString());
				itemReview.setAnimation(row.get("animation").toString());
				itemReview.setChildrens(row.get("childrens").toString());
				itemReview.setComedy(row.get("comedy").toString());
				itemReview.setCrime(row.get("crime").toString());
				itemReview.setDocumentary(row.get("documentary").toString());
				itemReview.setDrama(row.get("drama").toString());
				itemReview.setFantasy(row.get("fantasy").toString());
				itemReview.setFilmNoir(row.get("film_noir").toString());
				itemReview.setHorror(row.get("horror").toString());
				itemReview.setMusical(row.get("musical").toString());
				itemReview.setMystery(row.get("mystery").toString());
				itemReview.setRomance(row.get("romance").toString());
				itemReview.setSciFi(row.get("sci_fi").toString());
				itemReview.setThriller(row.get("thriller").toString());
				itemReview.setWar(row.get("war").toString());
				itemReview.setWestern(row.get("western").toString());
				itemReview.setFamily(row.get("family").toString());
				resultSet.add(itemReview);
			}
		} if(list.size() == 5) {
			String sql = "SELECT * FROM item_review where ("+list.get(0).toLowerCase()+"='1' and "+list.get(1).toLowerCase()+"='1') or ("+list.get(2).toLowerCase()+"='1' and "+list.get(3).toLowerCase()+"='1') or ("+list.get(4).toLowerCase()+"='1')";	
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			resultSet = new ArrayList<ItemReview>();
			for(Map<String, Object> row : rows){
				ItemReview itemReview = new ItemReview();
				itemReview.setId(Long.parseLong((row.get("item_id").toString())));
				itemReview.setAction(row.get("action").toString());
				itemReview.setAdventure(row.get("adventure").toString());
				itemReview.setAnimation(row.get("animation").toString());
				itemReview.setChildrens(row.get("childrens").toString());
				itemReview.setComedy(row.get("comedy").toString());
				itemReview.setCrime(row.get("crime").toString());
				itemReview.setDocumentary(row.get("documentary").toString());
				itemReview.setDrama(row.get("drama").toString());
				itemReview.setFantasy(row.get("fantasy").toString());
				itemReview.setFilmNoir(row.get("film_noir").toString());
				itemReview.setHorror(row.get("horror").toString());
				itemReview.setMusical(row.get("musical").toString());
				itemReview.setMystery(row.get("mystery").toString());
				itemReview.setRomance(row.get("romance").toString());
				itemReview.setSciFi(row.get("sci_fi").toString());
				itemReview.setThriller(row.get("thriller").toString());
				itemReview.setWar(row.get("war").toString());
				itemReview.setWestern(row.get("western").toString());
				itemReview.setFamily(row.get("family").toString());
				resultSet.add(itemReview);
			}
		}
		else {
		}
		return resultSet;
		}
	}

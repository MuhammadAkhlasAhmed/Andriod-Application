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
public class ItemReviewDaoImpl extends JdbcDaoSupport implements ItemReviewDao {

    public static List<ItemReview> resultSet;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public List<ItemReview> getAllItemReviews() {
        String sql = "SELECT * FROM item_review";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<ItemReview> result = new ArrayList<ItemReview>();
        for (Map<String, Object> row : rows) {
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
            itemReview.setHistory(row.get("history").toString());
            itemReview.setRealityTv(row.get("reality_tv").toString());
            itemReview.setMusic(row.get("music").toString());
            result.add(itemReview);
        }

        return result;
    }

    @Override
    public List<ItemReview> getRowAgainsGenres(List<String> list) {

        if (list.size() == 1 || list.get(0).equalsIgnoreCase("foreign")) {
        	String genre = "Drama";
            String sql = "SELECT * FROM item_review where (" + genre.toLowerCase() + "='1')";
            List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
            resultSet = new ArrayList<ItemReview>();
            for (Map<String, Object> row : rows) {
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
                itemReview.setHistory(row.get("history").toString());
                itemReview.setRealityTv(row.get("reality_tv").toString());
                itemReview.setMusic(row.get("music").toString());
                resultSet.add(itemReview);
            }
        }// end 1st if
        
        if (list.size() == 2) {
        	if(list.get(0).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
        		String sql = "SELECT * FROM item_review where " + genre.toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1'";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(1).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
        		String sql = "SELECT * FROM item_review where " + list.get(0).toLowerCase() + "='1' and " + genre.toLowerCase() + "='1'";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if (list.get(0).toLowerCase() != "foreign" &&  list.get(1).toLowerCase() != "foreign") {
        		String sql = "SELECT * FROM item_review where " + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1'";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	}
       }// end 2nd if
        if (list.size() == 3) {
        	if(list.get(0).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + genre.toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }

        	} if(list.get(1).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + genre.toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }

        	} if(list.get(2).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + genre.toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if (list.get(0).toLowerCase() != "foreign" &&  list.get(1).toLowerCase() != "foreign" && list.get(2).toLowerCase() != "foreign") {
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} 
        }// end 3rd if
        if (list.size() == 4) {
        	if(list.get(0).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + genre.toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(1).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + genre.toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(2).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + genre.toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(3).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1' and " + genre.toLowerCase() + "='1')";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if (list.get(0).toLowerCase() != "foreign" &&  list.get(1).toLowerCase() != "foreign" && list.get(2).toLowerCase() != "foreign" && list.get(3).toLowerCase() != "foreign") {
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1' and " + list.get(3).toLowerCase() + "='1')";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
			}
        } //end 4th if
        	if (list.size() == 5) {
        	if(list.get(0).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + genre.toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(1).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + genre.toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(2).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + genre.toLowerCase() + "='1') ";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(3).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1' and " + genre.toLowerCase() + "='1')";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if(list.get(4).equalsIgnoreCase("foreign")) {
        		String genre = "Drama";
                String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1' and " + list.get(3).toLowerCase() + "='1') or (" + genre.toLowerCase() + "='1')";
                List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
                resultSet = new ArrayList<ItemReview>();
                for (Map<String, Object> row : rows) {
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
                    itemReview.setHistory(row.get("history").toString());
                    itemReview.setRealityTv(row.get("reality_tv").toString());
                    itemReview.setMusic(row.get("music").toString());
                    resultSet.add(itemReview);
                }
        	} if (list.get(0).toLowerCase() != "foreign" &&  list.get(1).toLowerCase() != "foreign" && list.get(2).toLowerCase() != "foreign" && list.get(3).toLowerCase() != "foreign" && list.get(4).toLowerCase() != "foreign") {
            String sql = "SELECT * FROM item_review where (" + list.get(0).toLowerCase() + "='1' and " + list.get(1).toLowerCase() + "='1') or (" + list.get(2).toLowerCase() + "='1' and " + list.get(3).toLowerCase() + "='1') or (" + list.get(4).toLowerCase() + "='1')";
            List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
            resultSet = new ArrayList<ItemReview>();
            for (Map<String, Object> row : rows) {
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
                itemReview.setHistory(row.get("history").toString());
                itemReview.setRealityTv(row.get("reality_tv").toString());
                itemReview.setMusic(row.get("music").toString());
                resultSet.add(itemReview);
              }
            }
        }
        else {
		}
        return resultSet;
    }

	@Override
	public int save(List<String> movieGenres, List<String> allGenres, String feature) {
		if(feature.equalsIgnoreCase("like")) {
			int insert = 0;
			int update = 0;
		if(movieGenres.size() == 1) {
			String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+") values('1')";
			insert = getJdbcTemplate().update(sqlInsert);
			String sqlUpdate = "UPDATE item_review SET "+allGenres.get(0).toLowerCase()+"='0',"+movieGenres.get(1).toLowerCase()+"='0',"+movieGenres.get(2).toLowerCase()+"='0',"+movieGenres.get(3).toLowerCase()+"='0',"+movieGenres.get(4).toLowerCase()+"='0',"+movieGenres.get(5).toLowerCase()+"='0',"+movieGenres.get(6).toLowerCase()+"='0',"+movieGenres.get(7).toLowerCase()+"='0',"+movieGenres.get(8).toLowerCase()+"='0',"+movieGenres.get(9).toLowerCase()+"='0',"+movieGenres.get(10).toLowerCase()+"='0',"+movieGenres.get(11).toLowerCase()+"='0',"+movieGenres.get(12).toLowerCase()+"='0',"+movieGenres.get(13).toLowerCase()+"='0',"+movieGenres.get(14).toLowerCase()+"='0',"+movieGenres.get(15).toLowerCase()+"='0',"+movieGenres.get(16).toLowerCase()+"='0',"+movieGenres.get(17).toLowerCase()+"='0',"+movieGenres.get(18).toLowerCase()+"='0',"+movieGenres.get(19).toLowerCase()+"='0',"+movieGenres.get(20).toLowerCase()+"='0' WHERE "+movieGenres.get(0).toLowerCase()+" IS NULL or "+movieGenres.get(1).toLowerCase()+" IS NULL or "+movieGenres.get(2).toLowerCase()+" IS NULL or "+movieGenres.get(3).toLowerCase()+" IS NULL or "+movieGenres.get(4).toLowerCase()+" IS NULL or "+movieGenres.get(5).toLowerCase()+" IS NULL or "+movieGenres.get(6).toLowerCase()+" IS NULL or "+movieGenres.get(7).toLowerCase()+" IS NULL or "+movieGenres.get(8).toLowerCase()+" IS NULL or "+movieGenres.get(9).toLowerCase()+" IS NULL or "+movieGenres.get(10).toLowerCase()+" IS NULL or "+movieGenres.get(11).toLowerCase()+" IS NULL or "+movieGenres.get(12).toLowerCase()+" IS NULL or "+movieGenres.get(13).toLowerCase()+" IS NULL or "+movieGenres.get(14).toLowerCase()+" IS NULL or "+movieGenres.get(15).toLowerCase()+" IS NULL or "+movieGenres.get(16).toLowerCase()+" IS NULL or "+movieGenres.get(17).toLowerCase()+" IS NULL or "+movieGenres.get(18).toLowerCase()+" IS NULL or "+movieGenres.get(19).toLowerCase()+" IS NULL or "+movieGenres.get(20).toLowerCase()+" IS NULL";
			update = getJdbcTemplate().update(sqlUpdate);
		} if(movieGenres.size() == 2) {
			String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+") values('1','1')";
			insert = getJdbcTemplate().update(sqlInsert);
			String sqlUpdate = "UPDATE item_review SET "+allGenres.get(0).toLowerCase()+"='0',"+allGenres.get(1).toLowerCase()+"='0',"+allGenres.get(2).toLowerCase()+"='0',"+allGenres.get(3).toLowerCase()+"='0',"+allGenres.get(4).toLowerCase()+"='0',"+allGenres.get(5).toLowerCase()+"='0',"+allGenres.get(6).toLowerCase()+"='0',"+allGenres.get(7).toLowerCase()+"='0',"+allGenres.get(8).toLowerCase()+"='0',"+allGenres.get(9).toLowerCase()+"='0',"+allGenres.get(10).toLowerCase()+"='0',"+allGenres.get(11).toLowerCase()+"='0',"+allGenres.get(12).toLowerCase()+"='0',"+allGenres.get(13).toLowerCase()+"='0',"+allGenres.get(14).toLowerCase()+"='0',"+allGenres.get(15).toLowerCase()+"='0',"+allGenres.get(16).toLowerCase()+"='0',"+allGenres.get(17).toLowerCase()+"='0',"+allGenres.get(18).toLowerCase()+"='0',"+allGenres.get(19).toLowerCase()+"='0' WHERE "+allGenres.get(0).toLowerCase()+" IS NULL or "+allGenres.get(1).toLowerCase()+" IS NULL or "+allGenres.get(2).toLowerCase()+" IS NULL or "+allGenres.get(3).toLowerCase()+" IS NULL or "+allGenres.get(4).toLowerCase()+" IS NULL or "+allGenres.get(5).toLowerCase()+" IS NULL or "+allGenres.get(6).toLowerCase()+" IS NULL or "+allGenres.get(7).toLowerCase()+" IS NULL or "+allGenres.get(8).toLowerCase()+" IS NULL or "+allGenres.get(9).toLowerCase()+" IS NULL or "+allGenres.get(10).toLowerCase()+" IS NULL or "+allGenres.get(11).toLowerCase()+" IS NULL or "+allGenres.get(12).toLowerCase()+" IS NULL or "+allGenres.get(13).toLowerCase()+" IS NULL or "+allGenres.get(14).toLowerCase()+" IS NULL or "+allGenres.get(15).toLowerCase()+" IS NULL or "+allGenres.get(16).toLowerCase()+" IS NULL or "+allGenres.get(17).toLowerCase()+" IS NULL or "+allGenres.get(18).toLowerCase()+" IS NULL or "+allGenres.get(19).toLowerCase()+" IS NULL";
			update = getJdbcTemplate().update(sqlUpdate);
		} if(movieGenres.size() == 3) {
			String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+","+movieGenres.get(2).toLowerCase()+") values('1','1','1')";
			insert = getJdbcTemplate().update(sqlInsert);
			String sqlUpdate = "UPDATE item_review SET "+allGenres.get(0).toLowerCase()+"='0',"+allGenres.get(1).toLowerCase()+"='0',"+allGenres.get(2).toLowerCase()+"='0',"+allGenres.get(3).toLowerCase()+"='0',"+allGenres.get(4).toLowerCase()+"='0',"+allGenres.get(5).toLowerCase()+"='0',"+allGenres.get(6).toLowerCase()+"='0',"+allGenres.get(7).toLowerCase()+"='0',"+allGenres.get(8).toLowerCase()+"='0',"+allGenres.get(9).toLowerCase()+"='0',"+allGenres.get(10).toLowerCase()+"='0',"+allGenres.get(11).toLowerCase()+"='0',"+allGenres.get(12).toLowerCase()+"='0',"+allGenres.get(13).toLowerCase()+"='0',"+allGenres.get(14).toLowerCase()+"='0',"+allGenres.get(15).toLowerCase()+"='0',"+allGenres.get(16).toLowerCase()+"='0',"+allGenres.get(17).toLowerCase()+"='0',"+allGenres.get(18).toLowerCase()+"='0' WHERE "+allGenres.get(0).toLowerCase()+" IS NULL or "+allGenres.get(1).toLowerCase()+" IS NULL or "+allGenres.get(2).toLowerCase()+" IS NULL or "+allGenres.get(3).toLowerCase()+" IS NULL or "+allGenres.get(4).toLowerCase()+" IS NULL or "+allGenres.get(5).toLowerCase()+" IS NULL or "+allGenres.get(6).toLowerCase()+" IS NULL or "+allGenres.get(7).toLowerCase()+" IS NULL or "+allGenres.get(8).toLowerCase()+" IS NULL or "+allGenres.get(9).toLowerCase()+" IS NULL or "+allGenres.get(10).toLowerCase()+" IS NULL or "+allGenres.get(11).toLowerCase()+" IS NULL or "+allGenres.get(12).toLowerCase()+" IS NULL or "+allGenres.get(13).toLowerCase()+" IS NULL or "+allGenres.get(14).toLowerCase()+" IS NULL or "+allGenres.get(15).toLowerCase()+" IS NULL or "+allGenres.get(16).toLowerCase()+" IS NULL or "+allGenres.get(17).toLowerCase()+" IS NULL or "+allGenres.get(18).toLowerCase()+" IS NULL";
			update = getJdbcTemplate().update(sqlUpdate);
		} if(movieGenres.size() == 4) {
			String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+","+movieGenres.get(2).toLowerCase()+","+movieGenres.get(3).toLowerCase()+") values('1','1','1','1')";
			insert = getJdbcTemplate().update(sqlInsert);
			String sqlUpdate = "UPDATE item_review SET "+allGenres.get(0).toLowerCase()+"='0',"+allGenres.get(1).toLowerCase()+"='0',"+allGenres.get(2).toLowerCase()+"='0',"+allGenres.get(3).toLowerCase()+"='0',"+allGenres.get(4).toLowerCase()+"='0',"+allGenres.get(5).toLowerCase()+"='0',"+allGenres.get(6).toLowerCase()+"='0',"+allGenres.get(7).toLowerCase()+"='0',"+allGenres.get(8).toLowerCase()+"='0',"+allGenres.get(9).toLowerCase()+"='0',"+allGenres.get(10).toLowerCase()+"='0',"+allGenres.get(11).toLowerCase()+"='0',"+allGenres.get(12).toLowerCase()+"='0',"+allGenres.get(13).toLowerCase()+"='0',"+allGenres.get(14).toLowerCase()+"='0',"+allGenres.get(15).toLowerCase()+"='0',"+allGenres.get(16).toLowerCase()+"='0',"+allGenres.get(17).toLowerCase()+"='0' WHERE "+allGenres.get(0).toLowerCase()+" IS NULL or "+allGenres.get(1).toLowerCase()+" IS NULL or "+allGenres.get(2).toLowerCase()+" IS NULL or "+allGenres.get(3).toLowerCase()+" IS NULL or "+allGenres.get(4).toLowerCase()+" IS NULL or "+allGenres.get(5).toLowerCase()+" IS NULL or "+allGenres.get(6).toLowerCase()+" IS NULL or "+allGenres.get(7).toLowerCase()+" IS NULL or "+allGenres.get(8).toLowerCase()+" IS NULL or "+allGenres.get(9).toLowerCase()+" IS NULL or "+allGenres.get(10).toLowerCase()+" IS NULL or "+allGenres.get(11).toLowerCase()+" IS NULL or "+allGenres.get(12).toLowerCase()+" IS NULL or "+allGenres.get(13).toLowerCase()+" IS NULL or "+allGenres.get(14).toLowerCase()+" IS NULL or "+allGenres.get(15).toLowerCase()+" IS NULL or "+allGenres.get(16).toLowerCase()+" IS NULL or "+allGenres.get(17).toLowerCase()+" IS NULL";
			update = getJdbcTemplate().update(sqlUpdate);
		} if(movieGenres.size() == 5) {
			String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+","+movieGenres.get(2).toLowerCase()+","+movieGenres.get(3).toLowerCase()+","+movieGenres.get(4).toLowerCase()+") values('1','1','1','1','1')";
			insert = getJdbcTemplate().update(sqlInsert);
			String sqlUpdate = "UPDATE item_review SET "+allGenres.get(0).toLowerCase()+"='0',"+allGenres.get(1).toLowerCase()+"='0',"+allGenres.get(2).toLowerCase()+"='0',"+allGenres.get(3).toLowerCase()+"='0',"+allGenres.get(4).toLowerCase()+"='0',"+allGenres.get(5).toLowerCase()+"='0',"+allGenres.get(6).toLowerCase()+"='0',"+allGenres.get(7).toLowerCase()+"='0',"+allGenres.get(8).toLowerCase()+"='0',"+allGenres.get(9).toLowerCase()+"='0',"+allGenres.get(10).toLowerCase()+"='0',"+allGenres.get(11).toLowerCase()+"='0',"+allGenres.get(12).toLowerCase()+"='0',"+allGenres.get(13).toLowerCase()+"='0',"+allGenres.get(14).toLowerCase()+"='0',"+allGenres.get(15).toLowerCase()+"='0',"+allGenres.get(16).toLowerCase()+"='0' WHERE "+allGenres.get(0).toLowerCase()+" IS NULL or "+allGenres.get(1).toLowerCase()+" IS NULL or "+allGenres.get(2).toLowerCase()+" IS NULL or "+allGenres.get(3).toLowerCase()+" IS NULL or "+allGenres.get(4).toLowerCase()+" IS NULL or "+allGenres.get(5).toLowerCase()+" IS NULL or "+allGenres.get(6).toLowerCase()+" IS NULL or "+allGenres.get(7).toLowerCase()+" IS NULL or "+allGenres.get(8).toLowerCase()+" IS NULL or "+allGenres.get(9).toLowerCase()+" IS NULL or "+allGenres.get(10).toLowerCase()+" IS NULL or "+allGenres.get(11).toLowerCase()+" IS NULL or "+allGenres.get(12).toLowerCase()+" IS NULL or "+allGenres.get(13).toLowerCase()+" IS NULL or "+allGenres.get(14).toLowerCase()+" IS NULL or "+allGenres.get(15).toLowerCase()+" IS NULL or "+allGenres.get(16).toLowerCase()+" IS NULL";
			update = getJdbcTemplate().update(sqlUpdate);
		}
		return insert;
	}
		int insert = 0;
	if(movieGenres.size() == 1) {
		String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+") values('0')";
		insert = getJdbcTemplate().update(sqlInsert);
	} if(movieGenres.size() == 2) {
		String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+") values('0','0')";
		insert = getJdbcTemplate().update(sqlInsert);
	} if(movieGenres.size() == 3) {
		String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+","+movieGenres.get(2).toLowerCase()+") values('0','0','0')";
		insert = getJdbcTemplate().update(sqlInsert);
	} if(movieGenres.size() == 4) {
		String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+","+movieGenres.get(2).toLowerCase()+","+movieGenres.get(3).toLowerCase()+") values('0','0','0','0')";
		insert = getJdbcTemplate().update(sqlInsert);
	} if(movieGenres.size() == 5) {
		String sqlInsert = "insert into item_review ("+movieGenres.get(0).toLowerCase()+","+movieGenres.get(1).toLowerCase()+","+movieGenres.get(2).toLowerCase()+","+movieGenres.get(3).toLowerCase()+","+movieGenres.get(4).toLowerCase()+") values('0','0','0','0','0')";
		insert = getJdbcTemplate().update(sqlInsert);
	}
	return insert;
		}
	}

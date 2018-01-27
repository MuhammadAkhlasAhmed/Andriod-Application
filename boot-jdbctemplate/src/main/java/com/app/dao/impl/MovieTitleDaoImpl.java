package com.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.app.dao.MoviesTitleDao;
import com.app.model.MoviesTitle;

/**
 * The Class MovieTitleDaoImpl.
 */
@Repository
public class MovieTitleDaoImpl extends JdbcDaoSupport implements MoviesTitleDao {

    public static List<MoviesTitle> resultSet;

    public static List<String> listOfMovie;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    /**
     * The method that return movies against id.
     */
    @Override
    public List<MoviesTitle> getMovieAgainstId(List<Long> list) {
        if (list.size() == 1) {
            String sql = "SELECT * FROM movies_title where movie_id=" + list.get(0) + "";
            List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
            resultSet = new ArrayList<MoviesTitle>();
            for (Map<String, Object> row : rows) {
                MoviesTitle moviesTitle = new MoviesTitle();
                moviesTitle.setMovieId(Long.parseLong(row.get("movie_id").toString()));
                moviesTitle.setTitle(row.get("title").toString());
                resultSet.add(moviesTitle);
            }
        } if (list.size() == 2) {
            String sql = "SELECT * FROM movies_title where movie_id IN (" + list.get(0) + "," + list.get(1) + ")";
            List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
            resultSet = new ArrayList<MoviesTitle>();
            for (Map<String, Object> row : rows) {
                MoviesTitle moviesTitle = new MoviesTitle();
                moviesTitle.setMovieId(Long.parseLong(row.get("movie_id").toString()));
                moviesTitle.setTitle(row.get("title").toString());
                resultSet.add(moviesTitle);
            }
        } if (list.size() == 3 || list.size() > 3) {
            String sql = "SELECT * FROM movies_title where movie_id IN (" + list.get(0) + "," + list.get(1) + "," + list.get(2) + ")";
            List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
            resultSet = new ArrayList<MoviesTitle>();
            for (Map<String, Object> row : rows) {
                MoviesTitle moviesTitle = new MoviesTitle();
                moviesTitle.setMovieId(Long.parseLong(row.get("movie_id").toString()));
                moviesTitle.setTitle(row.get("title").toString());
                resultSet.add(moviesTitle);
            }
        }
        return resultSet;
    }

    /**
     * The method that save movie that user rate it.
     */
    @Override
    public int save(String movieName) {
        String sql = "insert into movies_title (title) values ('" + movieName + "')";
        int row = getJdbcTemplate().update(sql);
        return row;
    }

    /**
     * The method that true if movie exists.
     */
	@Override
	public boolean getMovieByName(String name) {
		String sql = "select * from movies_title where title ='"+name+"'";
		   List<MoviesTitle> listContact = getJdbcTemplate().query(sql, new RowMapper<MoviesTitle>() {
			   @Override
			   public MoviesTitle mapRow(ResultSet result, int rowNum) throws SQLException {
	                MoviesTitle contact = new MoviesTitle();
	                contact.setTitle(result.getString("title"));
	                return contact;
	            }
	        }); if(listContact.isEmpty()) {
			return false;
		}
			return true;
	}
}

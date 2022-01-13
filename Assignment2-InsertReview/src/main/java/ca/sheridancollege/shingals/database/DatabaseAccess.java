package ca.sheridancollege.shingals.database;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import ca.sheridancollege.shingals.beans.Review;

@Repository
public class DatabaseAccess {
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public ArrayList<Review> getAllReviews() {
		ArrayList<Review> reviews = null;
		String sql = "select * from reviews";
		reviews = (ArrayList<Review>) jdbc.query(sql, new BeanPropertyRowMapper<Review>(Review.class));
		return reviews;
	}

	public Review selectReview(int id) {
		Review r = null;
		String sql = "select * from reviews where id = :id";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("id", id);
		ArrayList<Review> reviews = (ArrayList<Review>) jdbc.query(sql, ps,
				new BeanPropertyRowMapper<Review>(Review.class));
		r = reviews.get(0);
		return r;
	}
	
	public void insertReview(Review review) {
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("id", review.getId());
		ps.addValue("name", review.getName());
		ps.addValue("Date", review.getDatee());
		ps.addValue("Time", review.getTimee());
		ps.addValue("review", review.getReview());
		String sql = "INSERT INTO reviews (id, name, date, time, review )VALUES (:id, :name, :datee, :timee, :review)";
		jdbc.update(sql, ps);
		
	}
	
	public void updateReview(Review review) {
		String sql = "update reviews set name=:name, date=:datee, time=:timee, review=:review where id=:id";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("id", review.getId());
		ps.addValue("name", review.getName());
		ps.addValue("Date", review.getDatee());
		ps.addValue("Time", review.getTimee());
		ps.addValue("review", review.getReview());
		jdbc.update(sql, ps);
	}
	
	public void deleteItem(int id) {
		String sql = "delete from reviews where id=:id";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("id", id);
		jdbc.update(sql, ps);
	}

}

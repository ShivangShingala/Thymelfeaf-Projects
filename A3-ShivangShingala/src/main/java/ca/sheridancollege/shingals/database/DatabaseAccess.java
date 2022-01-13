package ca.sheridancollege.shingals.database;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.shingals.beans.Discussion;

@Repository
public class DatabaseAccess {
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void insertDiscussion(Discussion discussion) {
		MapSqlParameterSource paraSource = new MapSqlParameterSource();
		paraSource.addValue("id", discussion.getId());
		paraSource.addValue("name", discussion.getName());
		paraSource.addValue("datee", discussion.getDatee());
		paraSource.addValue("thread", discussion.getThread());
		String sql = "INSERT INTO Discussions (id, name, datee, thread) VALUES (:id, :name, :datee, :thread)";
		jdbc.update(sql, paraSource);
	}
	
	public ArrayList<Discussion> getAllDiscussions() {
		ArrayList<Discussion> discussions = null;
		String sql = "SELECT * FROM Discussions";
		discussions = (ArrayList<Discussion>) jdbc.query(sql,
				new BeanPropertyRowMapper<Discussion>(Discussion.class));
		return discussions;
	}

}

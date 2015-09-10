package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;

import javax.persistence.*;

import java.util.List;

/**
 * Created by boris.tomic on 09/09/15.
 */
@Entity
@Table(name="error_log")
public class ErrorLog extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="message")
    private String message;

    @Column(name="loged_date", columnDefinition = "datetime")
    private DateTime logedDate = new DateTime();

    static Finder<Long, ErrorLog> finder = new Finder<Long, ErrorLog>(ErrorLog.class);

    /**
     * Default constructor
     * @param message <code>String</code> type value
     */
    public ErrorLog(String message) {
        this.message = message;

    }

    public static ErrorLog findErrorById(Long id) {

        List<ErrorLog> error = finder.where().eq("id", id).findList();
        if (error.size() == 0) {
            return null;
        }
        return (ErrorLog) error.get(0);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }

    public DateTime getDate() {
        return logedDate;
    }

    public static List<ErrorLog> findAllErrors() {
        return finder.all();
    }

}
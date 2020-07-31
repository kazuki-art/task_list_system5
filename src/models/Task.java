package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tasks")
@NamedQueries({
    @NamedQuery(
            name = "getAllTasks",
            query = "SELECT r FROM Task AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getTasksCount",
            query = "SELECT COUNT(r) FROM Task AS r"
            ),
    @NamedQuery(
            name = "getMyAllTasks",
            query = "SELECT r FROM Task AS r WHERE r.user = :user ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getMyTasksCount",
            query = "SELECT COUNT(r) FROM Task AS r WHERE r.user = :user"
            )
})
@Entity
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "limit2", length = 255, nullable = false)
    private String limit2;

    @Column(name = "start", length = 255, nullable = false)
    private String start;

    @Column(name = "finish", length = 255, nullable = false)
    private String finish;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLimit2() {
        return limit2;
    }

    public void setLimit2(String limit2) {
        this.limit2 = limit2;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }



}

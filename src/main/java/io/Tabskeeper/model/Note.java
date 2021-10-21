package io.Tabskeeper.model;

import javax.persistence.*;

@Entity
@Table(name = "note", schema = "public")
public class Note {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;

        @Column(nullable = true)
        private String title;

        @Column(nullable = false)
        private String body;

        public String getTitle() {
                return title;
        }

        public Long getId() {
                return id;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getBody() {
                return body;
        }

        public void setBody(String body) {
                this.body = body;
        }
}

package org.marystore.core.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TextInfo {

    @Id
    private TextInfoType id;
    @Column(length = 4096)
    private String text;

    public TextInfoType getId() {
        return id;
    }

    public void setId(TextInfoType id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("text", text)
                .toString();
    }
}

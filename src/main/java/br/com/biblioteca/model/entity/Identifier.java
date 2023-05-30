package br.com.biblioteca.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@Getter
@Setter
@RequiredArgsConstructor
@MappedSuperclass
public class Identifier implements Serializable {
    
    @Id
    @Column(nullable = false, insertable = false, 
			updatable = false, columnDefinition="serial")
    @Generated(GenerationTime.INSERT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
    
}

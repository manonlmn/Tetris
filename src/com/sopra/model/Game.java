/**
 * 
 */
package com.sopra.model;

import java.io.Serializable;

/**
 * @author mlemonnier
 *
 */
import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="game")
public class Game implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GAM_ID")
	private int idGame;
	
	@ManyToOne
	@JoinColumn(name = "GAM_ID_PLAYER1")
	@NotNull
	private Player Player1;
	
	@ManyToOne
	@JoinColumn(name = "GAM_ID_PLAYER2")
	private Player Player2;
	
	@Column(name = "GAM_SCORE")
	private int score;
}

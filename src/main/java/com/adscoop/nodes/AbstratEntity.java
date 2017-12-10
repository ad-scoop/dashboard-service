package com.adscoop.nodes;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;

@Getter @Setter
public abstract class AbstratEntity {

	@Getter
	@Setter
	@GraphId
	private Long id;

}

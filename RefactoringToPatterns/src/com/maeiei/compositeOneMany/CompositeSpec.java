package com.maeiei.compositeOneMany;

import java.util.ArrayList;
import java.util.List;

public class CompositeSpec extends Spec {

	private List<Spec> specs = new ArrayList<Spec>();
	
	public void add(Spec spec){
		specs.add(spec);
	}

	public List<Spec> getSpecs() {
		return specs;
	}

	public void setSpecs(List<Spec> specs) {
		this.specs = specs;
	}
}

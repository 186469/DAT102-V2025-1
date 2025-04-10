package no.hvl.dat102;

public class BS_Tre <T extends Comparable<? super T>> extends BinaerTre<T> 
implements SoeketreADT<T>{
	BS_Tre(){
		super();
	}
	
	BS_Tre(T rotElement){
		super(rotElement, null, null);
	}
	
	@Override
	public void setTre(T rotData) {
		// Vi ønskjer ikkje at denne metoden skal være tilgjengeleg
		// Ville i så fall være mulig å øydelegge det binære søketreet
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setTre(T rotData, BinaerTre<T> venstre, BinaerTre<T> hogre) {
		// Vi ønskjer ikkje at denne metoden skal være tilgjengeleg
		// Ville i så fall være mulig å øydelegge det binære søketreet
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean inneholder(T element) {

		return finn(element) != null;
	}

	@Override
	public T finn(T element) {
		
		return finn(element,getRot());
	}
	private T finn(T element, BinaerTreNode<T>p) {
		
		T svar = null;
		
		// Basis: p == 0 -> tomt tre, element finns ikke
		if(p != null) {
			int sml = element.compareTo(p.getElement());
			if(sml == 0) {
				svar = p.getElement();
			} else if(sml < 0) {
				svar = finn(element, p.getVenstre());
			} else {
				svar = finn(element, p.getHogre());
			}
		}
		return svar;
		
	}	

	@Override
	public T leggTil(T nyttElement) {
		
		if(getRot() == null) {
			setRot(new BinaerTreNode<T>(nyttElement));
			return null;
		} else {
			return leggTil(nyttElement, getRot());
		}
	}
	
	public T leggTil(T nyttElement, BinaerTreNode<T>p) {
		// Vet at p != null fordi metoden over fikser det
		
		T res = null;
		int sml = nyttElement.compareTo(p.getElement());
		
		if(sml == 0) {
			res = p.getElement();
			p.setElement(nyttElement);
		}
		if(sml < 0) {
			if(p.getVenstre() == null) { // Har funnet rett plass
				BinaerTreNode<T> ny = new BinaerTreNode<>(nyttElement);
				p.setVenstre(ny);
			} else {
				res = leggTil(nyttElement, p.getVenstre());
			}
		} else {
			if(p.getHogre() == null) { 
				BinaerTreNode<T> ny = new BinaerTreNode<>(nyttElement);
				p.setHogre(ny);
			} else {
				res = leggTil(nyttElement, p.getHogre());
			}
		}
		return res;
	}

	@Override
	public T fjern(T element) {
		/*
		 * Det er ikkje pensum å kunne skrive kode for denne.
		 */
		
		throw new UnsupportedOperationException();
	}
}

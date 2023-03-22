class Parser{
	static boolean parse(String s){
		try{
			int n=Integer.parseInt(s.trim());
			return true;
		}
		catch(Exception e){
			return false;
		}
	}


}
class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<List<String>>();
        Arrays.sort(products);
        for(int i = 1 ; i <= searchWord.length() ; i++){
        int count = 0;
         List<String> temp = new ArrayList<String>();
          for(int j = 0 ; j < products.length && count < 3 ; j++){
              if(i <= products[j].length()  && searchWord.substring(0,i).equals(products[j].substring(0,i))){
                  temp.add(products[j]);
                  count++;
              }
          }
            res.add(temp);
        }
        return res;
    }
}

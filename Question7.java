public class Question7{
    
    // Symbols:
    Object nextToken = "";
    String inc_op = "++";
    String dec_op = "--";
    String mult_op = "*";
    String greaterEq_op = ">=";
    String bitand_op = "&";
    String plus_op = "+";
    String minus_op = "-";
    String lessEq_op = "<=";
    String mod_op = "%";
    String greater_op = ">";
    String less_op = "<";
    String and_op = "&&";
    String div_op = "/";
    String not_op = "!";
    String or_op = "||";
    String xor_op = "~|";
    String assign_op = "=";
    String divEq_op = "/=";
    String id = "id";
    NumLit num_lit = new NumLit();
    
    // Other Methods: 
    // assign()
    // expr()
    // term1() 
    // term2()
    // term3()
    // term4()
    // factor1()
    // factor2()
    // pre()
    // post()
    // error()
    // lex()


    void assign() {
       if (nextToken != id){
           /* Get the next token */
            error();
       }else{
           lex();
           if (nextToken != assign_op || nextToken != divEq_op){
               error();
           }else{
               lex();
               expr();
           }
       }
   }


    void expr() {
        /* Parse the first term */
	 term1();
     /* As long as the next token is + or -, get
      the next token and parse the next term */
      while (nextToken == or_op || nextToken == xor_op) {
          lex();
          term1();
      }
   }

    void term1(){
        /* Parse the first factor */
         term2();
        /* As long as the next token is * or /, get the
         next token and parse the next factor */
         while (nextToken == and_op || nextToken == div_op || nextToken == not_op) {
             lex();
             term2();
         }
    }

    void term2(){
          /* Parse the first factor */
          term3();
          /* As long as the next token is * or /, get the
           next token and parse the next factor */
           while (nextToken == greater_op || nextToken == less_op) {
               lex();
               term3();
           }
    }

    void term3(){
        /* Parse the first factor */
        term4();
        /* As long as the next token is * or /, get the
         next token and parse the next factor */
         while (nextToken == plus_op || nextToken == minus_op || nextToken == mod_op) {
             lex();
             term4();
         }
    }

    void term4(){
        /* Parse the first factor */
        factor1();
        /* As long as the next token is * or /, get the
         next token and parse the next factor */
         while (nextToken == plus_op || nextToken == minus_op || nextToken == lessEq_op) {
             lex();
             factor1();
         }
    }

    void factor1(){
        /* Parse the first factor */
        factor2();
        /* As long as the next token is * or /, get the
         next token and parse the next factor */
         while (nextToken == mult_op || nextToken == greaterEq_op || nextToken == bitand_op) {
             lex();
             factor2();
         }
    }

    void factor2(){
        /* Parse the first factor */
        pre();
        /* As long as the next token is * or /, get the
         next token and parse the next factor */
         while (nextToken == inc_op || nextToken == dec_op) {
             lex();
             pre();
         }
    }

    void pre(){
        /* Parse the first factor */
        post();
        /* As long as the next token is * or /, get the
         next token and parse the next factor */
         while (nextToken == inc_op || nextToken == dec_op) {
             lex();
             post();
         }
    }

    void post(){
	/* Determine which RHS */
	 if (nextToken == id || nextToken == num_lit)
		/* Get the next token */
		 lex();
		/* If the RHS is ( <expr> ), call lex to pass over the
		 left parenthesis, call expr, and check for the right
		 parenthesis */
	 else { if (nextToken == "(") {
		 lex();
		 expr();
		 if (nextToken == ")")
		 	lex();
		 else
		 	error();
		 }
		/* It was not an id, an integer literal, or a left
		 parenthesis */
		 else
		 error();
	 }
    }

    void error(){

    }

    void lex(){

    }

    public static void main(String[] args){

    }
}
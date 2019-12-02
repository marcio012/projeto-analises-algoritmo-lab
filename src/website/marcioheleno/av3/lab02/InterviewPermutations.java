package website.marcioheleno.av3.lab02;

import java.util.ArrayList;

public class InterviewPermutations {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        // Validação de entrada
        if( a == null )
            throw new IllegalArgumentException( "A entrada não pode ser nula" );

        ArrayList<ArrayList<Integer>> toReturn = new ArrayList<ArrayList<Integer>>();

        if( a.size() == 1 ){
            toReturn.add( new ArrayList<Integer>(a) );
            return toReturn;
        }

        // Loop em todos os elementos.
        for( int i = 0 ; i < a.size(); i++ ){
            int current = a.get( i );
            ArrayList<Integer> tmp = new ArrayList<Integer>(a);
            tmp.remove( i );

            // Chame recursivamente com subconjunto
            ArrayList<ArrayList<Integer>> res = permute(tmp);

            // Crie o resultado da sub-lista retornada
            for( int j = 0 ; j < res.size() ; j++ ){
                ArrayList<Integer> toAdd = new ArrayList<Integer>();
                toAdd.add( current );
                toAdd.addAll( res.get( j ) );

                toReturn.add( toAdd );
            }
        }

        // devolver os resultados
        return toReturn;
    }

    public static void main(String[] argv) throws Exception {
        InterviewPermutations t = new InterviewPermutations();

        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add( 1 );
        a.add( 2 );
        a.add( 3 );


        System.out.println( "Arranjo inicial:" );
        System.out.println( a );


        ArrayList<ArrayList<Integer>> res = t.permute(a);

        System.out.println( "Resultado:" );
        for(ArrayList<Integer> c : res ){
            System.out.println( c );
        }

    }

}

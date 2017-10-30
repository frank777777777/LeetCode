/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.*/
public class Word_Search {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || word.length() == 0){
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        /* first try to match the first char, and then use the helper method to match the rest */
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                /* the first char is match, then try to match the rest */
                if(board[i][j] == word.charAt(0)){
                    if(existHelper(board, word, visited, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }
    private boolean existHelper(char[][] board, String word, boolean[][] visited, int i, int j, int pos){
        if(pos == word.length())
            return true;
        /* if either i, j or pos is out of bound, return false, if this is visited, or this this char does not match, return false */
        if(i < 0 || j < 0 || i == board.length || j == board[0].length){
            return false;
        }
        if(visited[i][j] || board[i][j] != word.charAt(pos)){
            return false;
        }
        /* now officially visiting this node */
        visited[i][j] = true;
        /* try 4 directions */
        boolean exist = existHelper(board, word, visited, i, j + 1, pos + 1) ||
        existHelper(board, word, visited, i, j - 1, pos + 1) ||
        existHelper(board, word, visited, i + 1, j, pos + 1) ||
        existHelper(board, word, visited, i - 1, j, pos + 1);
        if(exist) return true;
        /* we cannot find any thing in this node , set this is not visited before leaving */
        visited[i][j] = false;
        return exist;
    }

    public static void main(String[] args){
        char[][] board = new char[][]{
                {'A','B', 'C', 'E'},
                {'S','F', 'E', 'S'},
                {'A','D', 'E', 'E'}};
        String word = "ABCESEEDASF";
        System.out.println(new Word_Search().exist(board, word));
    }
}

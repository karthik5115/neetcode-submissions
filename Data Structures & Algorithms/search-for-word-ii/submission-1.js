class TrieNode {
  // Use a clean array or object map for tracking children
  children = {};
  // Store the full word string at the leaf node to easily collect it
  word = null; 
}

class Solution {
  /**
   * @param {character[][]} board
   * @param {string[]} words
   * @return {string[]}
   */
  findWords(board, words) {
    const root = new TrieNode();
    const res = [];

    // --- STEP 1: Insert all target words into the Trie ---
    for (const word of words) {
      let node = root;
      for (const char of word) {
        if (!node.children[char]) {
          node.children[char] = new TrieNode();
        }
        node = node.children[char];
      }
      node.word = word; // Store the complete word string at the end node
    }

    // --- STEP 2: Run Pruned DFS on the board grid ---
    const rows = board.length;
    const cols = board[0].length;

    for (let i = 0; i < rows; i++) {
      for (let j = 0; j < cols; j++) {
        // Only start searching if the starting letter exists in our Trie root
        if (root.children[board[i][j]]) {
          this.dfs(i, j, root.children[board[i][j]], board, res);
        }
      }
    }

    return res;
  }

  dfs(i, j, node, board, res) {
    // If we reached a leaf node that holds a complete word, grab it!
    if (node.word) {
      res.push(node.word);
      node.word = null; // Clear it to avoid adding duplicate words to our results
    }

    const char = board[i][j];
    board[i][j] = '#'; // In-place backtracking marker (avoids needing a separate visited matrix)

    // Direction arrays for traveling Up, Down, Left, Right
    const rowOffsets = [-1, 1, 0, 0];
    const colOffsets = [0, 0, -1, 1];

    for (let d = 0; d < 4; d++) {
      const nextRow = i + rowOffsets[d];
      const nextCol = j + colOffsets[d];

      // Boundary safety checks
      if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length) {
        const nextChar = board[nextRow][nextCol];
        // Pruning step: Only descend if the adjacent board character exists in the Trie branch
        if (node.children[nextChar]) {
          this.dfs(nextRow, nextCol, node.children[nextChar], board, res);
        }
      }
    }

    board[i][j] = char; // Backtrack restore step
  }
}
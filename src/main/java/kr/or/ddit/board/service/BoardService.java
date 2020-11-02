package kr.or.ddit.board.service;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.board.repository.BoardRepositoryI;

public class BoardService implements BoardServiceI{
   
   private BoardRepositoryI boardRepository;

   public BoardRepositoryI getBoardRepository() {
      return boardRepository;
   }

   public void setBoardRepository(BoardRepositoryI boardRepository) {
      this.boardRepository = boardRepository;
   }
   
   public BoardService() {
      // TODO Auto-generated constructor stub
   }

   public BoardService(BoardRepositoryI boardRepository) {
      this.boardRepository=boardRepository;
   }
   
   @Override
   public BoardVO getBoard(int boardNo) {
      return boardRepository.getBoard(boardNo);
   }
   
}
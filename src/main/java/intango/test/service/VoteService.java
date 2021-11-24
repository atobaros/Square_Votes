package intango.test.service;



import java.util.Set;

import intango.test.ColorVote;
import intango.test.exceptions.VoteException;

public interface VoteService {

	public void addColorVote(ColorVote colorVote) throws VoteException;

	public Set<ColorVote> getColorVotes() throws VoteException;
	
	public void voteFor(int colorId)throws VoteException ;

}

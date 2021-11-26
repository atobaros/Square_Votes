package intango.test.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.springframework.stereotype.Service;
import intango.test.ColorVote;
import intango.test.exceptions.VoteException;

@Service
public class ColorVoteService implements VoteService {

	private Set<ColorVote> set = new HashSet<>();

	public ColorVoteService() {

		set.add(new ColorVote(0, "green", 0));
		set.add(new ColorVote(1, "pink", 0));
		set.add(new ColorVote(2, "blue", 0));
		set.add(new ColorVote(3, "black", 0));
		set.add(new ColorVote(4, "grey", 0));
		set.add(new ColorVote(5, "yellow", 0));
		set.add(new ColorVote(6, "purple", 0));
		set.add(new ColorVote(7, "red", 0));

	}

	@Override
	public void addColorVote(ColorVote colorVote) throws VoteException {

		Iterator<ColorVote> iter = set.iterator();
		while (iter.hasNext()) {
			ColorVote color = iter.next();
			if (color.getColor().equals(colorVote.getColor())) {
				throw new VoteException("Color already exists");
			}
			if (color.getId() == colorVote.getId()) {
				throw new VoteException("ID already exists");
			}

		}
		set.add(colorVote);

	}

	@Override
	public Set<ColorVote> getColorVotes() throws VoteException {
		return set;
	}

	@Override
	public void voteFor(int colorId) throws VoteException {
		Iterator<ColorVote> iter = set.iterator();
		while (iter.hasNext()) {
			ColorVote color = iter.next();
			if (color.getId() == colorId) {
				color.setNumberOfVotes(color.getNumberOfVotes()+1);
				System.out.println(color);
			}

		}
         
	}

}

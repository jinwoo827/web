package member;

public class ServiceImpl implements Service{
	private Dao dao;
	public ServiceImpl(Dao dao){
		this.dao = dao;
	}

	@Override
	public void addMember(Member m) {
		// TODO Auto-generated method stub
		dao.insert(m);
	}

	@Override
	public Member getMember(String id) {
		// TODO Auto-generated method stub
		return dao.select(id);
	}

	@Override
	public String login(Member m) {
		// TODO Auto-generated method stub
		
		Member m2 = null;
		String result = null;
		m2 = getMember(m.getId());
		if(m2 == null){
			result = "incorrect id";
		} else if(!m2.getPwd().equals(m.getPwd())){
			result = "incorrect pwd";
		}		
		return result;
	}

	@Override
	public void editMember(Member m) {
		// TODO Auto-generated method stub
		dao.update(m);
	}

	@Override
	public void delMember(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}


}

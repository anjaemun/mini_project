package ShoppingMall.Repository;

import ShoppingMall.DTO.MemberDTO;
import ShoppingMall.LoginCheck;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    List<MemberDTO> memberDTOList = new ArrayList<>();

    public boolean memberJoin(MemberDTO memberDTO) {
        return memberDTOList.add(memberDTO);
    }

    public boolean memberLogin(String memberId, String memberPassword) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberId.equals(memberDTO.getMemberId()) && memberPassword.equals(memberDTO.getMemberPassword())) {
                LoginCheck.memberLoginId = memberId;
                return true;
            }
        }
        return false;
    }
}

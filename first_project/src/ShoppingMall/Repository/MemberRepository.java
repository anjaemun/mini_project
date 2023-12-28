package ShoppingMall.Repository;

import ShoppingMall.DTO.GoodsDTO;
import ShoppingMall.DTO.MemberDTO;
import ShoppingMall.DTO.OrderDTO;
import ShoppingMall.LoginCheck;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    List<MemberDTO> memberDTOList = new ArrayList<>();
    List<OrderDTO> orderDTOList = new ArrayList<>();
    List<GoodsDTO> goodsDTOList = new ArrayList<>();

    public boolean memberJoin(MemberDTO memberDTO) {
        return memberDTOList.add(memberDTO);
    }

    public boolean memberLogin(String memberId, String memberPassword) {
        int count = 0;
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberId.equals(memberDTO.getMemberId()) && memberPassword.equals(memberDTO.getMemberPassword())) {
                LoginCheck.memberLoginId = memberId;
                ++count;
                if (count == 1) {
                    int point = memberDTO.getPoint();
                    point += 1000;
                    memberDTO.setPoint(point);
                }
                return true;
            }
        }
        return false;
    }

    public Integer point(String memberLoginId) {
        int point = 0;
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberLoginId.equals(memberDTO.getMemberId())) {
                point = memberDTO.getPoint();
                return point;
            }
        }
        return point;
    }

    public List<OrderDTO> orderList() {
        return orderDTOList;
    }


}

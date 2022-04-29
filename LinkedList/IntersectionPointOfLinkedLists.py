def findIntersection(self,one,two):
        on=one.head
        tn=two.head
        if one.size > two.size:
            i = 0
            while i < one.size - two.size:
                on = on.next
                i += 1
        else:
            i = 0
            while i < two.size - one.size:
                tn = tn.next
                i += 1

        while on is not tn:
            on = on.next
            tn = tn.next

        return on.data

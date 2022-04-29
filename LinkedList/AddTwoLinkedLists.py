def _addTwoLists(self, on, tn, pio, pit, res):
        if on is None and tn is None:
            return 0


        carry = 0
        data = 0
        if pio > pit:
            carry = self._addTwoLists(on.next, tn, pio - 1, pit, res)
            data = carry + on.data
        elif pio < pit:
            carry = self._addTwoLists(on, tn.next, pio, pit - 1, res)
            data = carry + tn.data
        else:
            carry = self._addTwoLists(on.next, tn.next, pio - 1, pit - 1, res)
            data = carry + on.data + tn.data
    
        carry = int(data / 10)
        data = data % 10
    
        res.addFirst(data)
        return carry
    

    def addTwoLists(self,one, two):
        res = LinkedList()

        carry = self._addTwoLists(one.head, two.head, one.size, two.size, res)
        if carry > 0:
            res.addFirst(carry)

        return res

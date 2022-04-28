def __IsPalindromeHelper(self, right):
        if right is None:
            return True
        rres = self.__IsPalindromeHelper(right.next)
        if rres == False:
            return False
        elif self.pleft.data != right.data:
            return False
        else:
            self.pleft = self.pleft.next
            return True

    def IsPalindrome(self):
        self.pleft = self.head
        return self.__IsPalindromeHelper(self.head)

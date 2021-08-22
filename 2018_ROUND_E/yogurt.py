class Case:
    def __init__(self, bought, limit_per_day, yogurt_exp):
        self.bought = bought
        self.limit_per_day = limit_per_day
        self.yogurt_exp = sorted(yogurt_exp)
        self.consumed = 0

    def consume(self):
        day = 0
        consumed_per_day = 0
        for i in range(self.bought):
            if consumed_per_day == self.limit_per_day:
                day += 1
                consumed_per_day = 0

            if self.yogurt_exp[i] > day:
                consumed_per_day += 1
                self.consumed += 1

        return self.consumed


t = int(input())
for i in range(1, t+1):
    n, k = [int(j) for j in input().split()]
    expire_list = [int(k) for k in input().split()]
    case = Case(bought=n, limit_per_day=k, yogurt_exp=expire_list)
    print(f"Case #{i}: {case.consume()}")
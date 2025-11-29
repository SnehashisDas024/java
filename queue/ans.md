**Dota2 Senate (LeetCode 649) – Clear Explanation + Solution**

The problem simulates a battle between two parties: **Radiant (R)** and **Dire (D)**. Senators take turns in order, and each senator can ban one opponent’s future turn. Banned senators lose all future actions. The rounds continue in a cycle until only one party remains.

---

## **How the Game Works (Simplified)**

1. You are given a string like `"RDD"`.
2. You iterate senators in order:

   * An active senator bans the next available opponent.
3. When you reach the end of the string, you loop back to the start.
4. Continue until all senators belong to one faction.

A very efficient way is to use **two queues**, one for Radiant and one for Dire, containing their indices.

---

## **Intuition**

* Each queue stores positions:

  * Radiant: `R_queue`
  * Dire: `D_queue`
* The earliest index acts first.
* Whoever has the smaller index acts first, and the winner gets reinserted with an index offset by the full length of the original string — meaning “they will act again next round.”

---

## **Example**

Input: `"RDD"`

Initial:

* R_queue = [0]
* D_queue = [1, 2]

Round 1:

* Compare top: R=0, D=1 → R acts first
* R bans D at index 1
* Put R back as 0 + 3 = 3
  R_queue = [3], D_queue = [2]

Round 2:

* Compare: R=3, D=2 → D acts first
* D bans R at index 3
* D goes back as 2 + 3 = 5
  D_queue = [5], R_queue = []

Radiant empty → **Dire wins**

---

## **Efficient Code (Python)**

```python
from collections import deque

def predictPartyVictory(senate: str) -> str:
    n = len(senate)
    R, D = deque(), deque()

    for i, c in enumerate(senate):
        if c == "R":
            R.append(i)
        else:
            D.append(i)

    while R and D:
        r = R.popleft()
        d = D.popleft()

        if r < d:
            # Radiant acts first → ban Dire
            R.append(r + n)
        else:
            # Dire acts first → ban Radiant
            D.append(d + n)

    return "Radiant" if R else "Dire"
```

---

## **Want help optimizing, debugging, or converting to another language?**

Just tell me what you need!

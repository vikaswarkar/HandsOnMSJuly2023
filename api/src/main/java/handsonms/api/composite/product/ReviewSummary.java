package handsonms.api.composite.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ReviewSummary {
    private final int reviewId;
    private final String author;
    private final String subject;
}

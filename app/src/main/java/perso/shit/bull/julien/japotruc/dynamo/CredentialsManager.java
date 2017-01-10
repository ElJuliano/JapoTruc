package perso.shit.bull.julien.japotruc.dynamo;

import android.content.Context;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;

/**
 * Created by Julien on 10/01/2017.
 */

public class CredentialsManager {
    private CognitoCachingCredentialsProvider credentialsProvider;

    public CredentialsManager (Context applicationContext) {
        // Initialize the Amazon Cognito credentials provider
        credentialsProvider = new CognitoCachingCredentialsProvider(
                applicationContext,
                "us-west-2:18da794e-92e1-4772-857d-f72686bf803f", // Identity Pool ID
                Regions.US_WEST_2 // Region
        );
    }
    public CognitoCachingCredentialsProvider getCredentialPrvider() {
        return this.credentialsProvider;
    }
}
